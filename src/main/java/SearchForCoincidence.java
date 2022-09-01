import org.apache.commons.text.similarity.JaccardSimilarity;

import java.util.*;


public class SearchForCoincidence {

    private static final List<List<String>> allProds = new ArrayList<>();

    public static List<List<String>> getAllProds() {
        return allProds;
    }

    public List<String> searchCoincidence() {
        List<String> result = new ArrayList<>();
        List<Double> elementsSimilarity = new ArrayList<>();
        List<String> firstHalfOfProds = allProds.get(0);
        List<String> secondHalfOfProds = allProds.get(1);
        if (allProds.get(0).size() == 1 && allProds.get(1).size() == 1) {
            result.add(firstHalfOfProds.get(0) + ":" + secondHalfOfProds.get(0));
            return result;
        }
        for (int i = 0; i < firstHalfOfProds.size(); i++) {
            for (int j = 0; j < allProds.get(1).size(); j++) {
                elementsSimilarity.add(diff(firstHalfOfProds.get(i).toLowerCase(),
                        secondHalfOfProds.get(j).toLowerCase()));
            }
            double maxSimilarity = Collections.max(elementsSimilarity);
            if (maxSimilarity < 0.300)
                result.add(firstHalfOfProds.get(i) + ":" + "?");
            else {
                result.add(firstHalfOfProds.remove(i) + ":" +
                        secondHalfOfProds.remove(elementsSimilarity.indexOf(maxSimilarity)));
                i--;
            }
            elementsSimilarity = new ArrayList<>();
        }
        if (secondHalfOfProds.size() > 0)
            for (String s : secondHalfOfProds)
                result.add(s + ":" + "?");
        return result;
    }

    private double diff(String first, String second) {
        return new JaccardSimilarity().apply(first, second);
    }

}


