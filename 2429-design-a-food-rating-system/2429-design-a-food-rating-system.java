import java.util.*;

class Food {
    String name;
    String cuisine;
    int rates;
    Food(String n, String c, int r) {
        name = n;
        cuisine = c;
        rates = r;
    }
}

class FoodRatings {
    private Map<String, Food> food2Foods;
    private Map<String, TreeSet<Food>> cuisine2Foods;

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        food2Foods = new HashMap<>();
        cuisine2Foods = new HashMap<>();
        for (int i = 0; i < foods.length; i++) {
            Food f = new Food(foods[i], cuisines[i], ratings[i]);
            food2Foods.put(foods[i], f);
            cuisine2Foods
                .computeIfAbsent(cuisines[i], k -> new TreeSet<>( (a, b) -> {
                    if (a.rates != b.rates) return Integer.compare(b.rates, a.rates);
                    return a.name.compareTo(b.name);
                }))
                .add(f);
        }
    }
    
    public void changeRating(String food, int newRating) {
        Food foo = food2Foods.get(food);
        TreeSet<Food> set = cuisine2Foods.get(foo.cuisine);
        set.remove(foo);
        foo.rates = newRating;
        set.add(foo);
    }
    
    public String highestRated(String cuisine) {
        return cuisine2Foods.get(cuisine).first().name;
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */