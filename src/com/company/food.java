package com.company;

class Food {

    private final int servingSize;
    private final int servings;
    private final int calories;
    private final int fat;
    private final int sodium;
    private final int carbohydrate;

    public static class Builder {
        // Required parameters(필수 인자)
        private final int svSize;
        private final int sv;
        
        //추가 인자
        private int calories      = 0;
        private int fat           = 0;
        private int carbohydrate  = 0;
        private int sodium        = 0;

        public Builder(int servingSize, int servings) {
            this.svSize = servingSize;
            this.sv     = servings;
        }

        public Builder calories(int val) {
            calories = val;
            return this;
        }
        public Builder fat(int val) {
            fat = val;
            return this;
        }
        public Builder carbohydrate(int val) {
            carbohydrate = val;
            return this;
        }
        public Builder sodium(int val) {
            sodium = val;
            return this;
        }
        public Food build() {
            return new Food(this);
        }
    }

    public Food(Builder builder) {
        this.servingSize  = builder.svSize;
        this.servings     = builder.sv;
        this.calories     = builder.calories;
        this.fat          = builder.fat;
        this.sodium       = builder.sodium;
        this.carbohydrate = builder.carbohydrate;
    }

    //getter
    public String getInfo(){
        String foodInfo = String.format("servingSize: %d, servings: %d, calories: %d, fat: %d, sodium: %d, carbohydrate: %d"
                , servingSize, servings, calories, fat, sodium, carbohydrate);
        return foodInfo;
    }
}

