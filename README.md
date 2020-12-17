Goals post reviews, add hotels, make some dashboard stuff.

## Events, commands & actors:

    Review domain:
    RegisterHotel
    HotelRegisterd
    HotelManager

    PostReview
    GuestPlacedAReview
        -> triggers e-mail telling hotel manager a review was placed.
    Guest

    PostReview
    GuestPlacedADraftReview
        -> triggers e-mail telling moderator a review was placed.
    Guest

    ModerateReview
    ReviewModerated
        -> triggers e-mail telling guest review was approved.
        -> changes the review state
    Moderator

#### Invariants:
1. A review must be approved by a moderator if the reviewer has less than 4 reviews.

## Identity Access Domain

    User:
        UserRegistered
        UserEmailVerified
        UserPasswordChanged
        UserPassword
        UserProfileUpdated

## Domain objects:

    Hotel
        Name
        Country
        Address
    
    Review
        hotelId
        authorId
        date
        positives
        negatives
        isDraft --> maybe a DraftReview would be better
        score
    
    Reviewer
        Name
        Nationality
        amountOfReviewsPosted --> used for validation of invariant 1
        ---
        postReview(hotelId, reviewDetails)


Pseudo code:
    
    DomainService: postReview
    reviever = reviewerRepo.getById(...)
    events = eventStore.getEventsForAggregateId(id)
    reviewer.loadFromHistory(events)
    loadFromHistory(evts)
    e in evts
    apply(e)

        Reviewer.postReview(hotelId)
            // protect invariants
            apply(new ReviewWasPosted(...))
    
        Reviewer.when(ReviewWasPosted)
            // update aggregate state
            amountOfReviewsPosted++
    
        revieverRepo.save(reviewer)
            eventStore.saveEvents(reviewer.events)
                // project aggregate version against concurrency conflicts
            publisher.publishEvents(reviewer.events)

## Data

Simulating around 500k events with data from:
https://www.kaggle.com/jiashenliu/515k-hotel-reviews-data-in-europe

## References:

- https://www.youtube.com/watch?v=whCk1Q87_ZI
- https://www.youtube.com/watch?v=LDW0QWie21s
- https://www.youtube.com/watch?v=m1FhLPmiK9A
- https://cqrs.files.wordpress.com/2010/11/cqrs_documents.pdf
- https://github.com/gregoryyoung/m-r/tree/master/SimpleCQRS
- https://github.com/VaughnVernon/IDDD_Samples
- https://github.com/EventStore/EventStore
- https://www.youtube.com/watch?v=DWhQggR13u8
- https://www.youtube.com/watch?v=A0goyZ9F4bg
- https://www.youtube.com/watch?v=7kX3fs0pWwc
- https://www.youtube.com/watch?v=I3uH3iiiDqY
- Microservices Evolution: How to break your monolithic database by Edson Yanaga
- https://www.youtube.com/watch?v=6dfBd-2Oq1M
- Microservices Data Patterns: CQRS & Event Sourcing by Edson Yanaga
- https://www.youtube.com/watch?v=eyf2Fs7GBo0
