package com.amazon.utility;

import java.util.Random;

public class Utility {


        private final String[] domains = {"gmail.com", "yahoo.com", "hotmail.com", "outlook.com", "example.com"};
        private final String[] prefixes = {"john", "jane", "smith", "doe", "alex", "emma", "mike", "sara"};

        public String generateEmail() {
            Random random = new Random();
            String prefix = prefixes[random.nextInt(prefixes.length)];
            String domain = domains[random.nextInt(domains.length)];
            int randomNumber = random.nextInt(10000); // Generate a random number for uniqueness
            return prefix + randomNumber + "@" + domain;


        }
}
