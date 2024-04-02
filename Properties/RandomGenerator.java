package Properties;

import java.util.Random;

public class RandomGenerator {

    public String generateRandomString(int length) {

        String characters = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            sb.append(characters.charAt(index));
        }

        return sb.toString();
    }

    public int generateRandomInteger(int min, int max) {

        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }

    public double generateRandomDouble(double min, double max) {

        Random random = new Random();
        return min + (max - min) * random.nextDouble();
    }
}
