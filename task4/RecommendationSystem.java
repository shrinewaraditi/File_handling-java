import java.util.*;

public class RecommendationSystem {

    public static void main(String[] args) {

        // Sample Data
        Map<String, Map<String, Integer>> data = new HashMap<>();

        Map<String, Integer> user1 = new HashMap<>();
        user1.put("Laptop", 5);
        user1.put("Mobile", 3);

        Map<String, Integer> user2 = new HashMap<>();
        user2.put("Laptop", 4);
        user2.put("Headphones", 5);

        Map<String, Integer> user3 = new HashMap<>();
        user3.put("Mobile", 5);
        user3.put("Headphones", 4);

        data.put("User1", user1);
        data.put("User2", user2);
        data.put("User3", user3);

        // Target user
        String targetUser = "User1";

        System.out.println("Recommendations for " + targetUser + ":");

        Set<String> recommendedItems = new HashSet<>();

        // Get target user's items
        Set<String> userItems = data.get(targetUser).keySet();

        // Compare with other users
        for (String otherUser : data.keySet()) {

            if (!otherUser.equals(targetUser)) {

                Set<String> otherItems = data.get(otherUser).keySet();

                // Check similarity (common items)
                Set<String> commonItems = new HashSet<>(userItems);
                commonItems.retainAll(otherItems);

                if (!commonItems.isEmpty()) {
                    for (String item : otherItems) {
                        if (!userItems.contains(item)) {
                            recommendedItems.add(item);
                        }
                    }
                }
            }
        }

        // Display results
        if (recommendedItems.isEmpty()) {
            System.out.println("No recommendations found.");
        } else {
            for (String item : recommendedItems) {
                System.out.println(item);
            }
        }
    }
}