fun main() {
    
    val comments: MutableList<Comment> = mutableListOf(
        Comment(5241, "Nice code"),
        Comment(6624, "Like it"),
        Comment(5224, "What's going on ?"),
        Comment(9001, "Check out my website"),
        Comment(8818, "Hello everyone,:)")
    )

    val blockedUserIds: Set<Int> = mutableSetOf(5224, 9001)

    val relationships: Map<Int, String> = mutableMapOf(
        5241 to "Friend",
        6624 to "Work Colleague"
    )

    for(comment in comments) {
        if(!blockedUserIds.contains(comment.userId)) {
            val relation = relationships[comment.userId] ?: "Unknown"
            println("Comment: ${comment.message} from $relation")
        }
    }
}