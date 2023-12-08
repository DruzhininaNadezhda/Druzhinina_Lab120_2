package lab120_2.scriptingLanguage;
import java.util.*;
public class DataProcessing2 {
    public void encryptValue(LinkedList <String> originalFile) {
        TreeMap<String, Integer> variablesAndTheirValues = new TreeMap<>();
        String result ="";
        StringBuilder expressionNumber = new StringBuilder();
        StringBuilder expression = new StringBuilder();
        int summa =0;

        for (String h : originalFile) {
            if (h.contains("print \"$")) {
                h = h.replace("print \"$", "")
                        .replaceAll("[,$\" ]", "");
                if (h.contains(result)) {
                    expressionNumber = new StringBuilder(result);
                    expression = new StringBuilder(result);
                    for (String t : variablesAndTheirValues.keySet()) {
                        if (h.contains(t)) {
                            char plusOrMinus = h.charAt((h.lastIndexOf(t) - 1));
                            if (plusOrMinus == '=') {
                                summa =variablesAndTheirValues.get(t);
                            }
                            else if (plusOrMinus == '+') {
                                summa = variablesAndTheirValues.get(t) + summa;
                            } else if (plusOrMinus == '-') {
                                summa -= variablesAndTheirValues.get(t);
                            }
                            expressionNumber.append(plusOrMinus).append(variablesAndTheirValues.get(t));
                            expression.append(plusOrMinus).append(t);
                        } else if (!h.contains(t)) {
                            System.out.println("Переменные чисел не совпадают");
                            System.exit(0);
                        }
                    }
                } else if (!h.contains(result)) {
                    System.out.println("Наименования переменной суммы отличаются");
                    System.exit(0);
                }
                String[] s =h.replace(expression, "")
                             .split("\\D+");
                        Integer numbers1 = Integer.parseInt(String.join("", s));
                        if (h.contains(numbers1.toString())) {
                            char plusOrMinus = h.charAt((h.indexOf(numbers1.toString()) - 1));
                            if (plusOrMinus == '+') {
                                summa = numbers1 + summa;
                            } else if (plusOrMinus == '-') {
                                summa -= numbers1;
                            }
                            expressionNumber.append(plusOrMinus).append(numbers1);
                            expression.append(plusOrMinus).append(numbers1);
                        }

                   System.out.println("$"+expressionNumber + "=" + summa);
            } else if (h.contains("print \"")) {
                System.out.println(h.replace("print \"", "")
                                     .replaceAll("[\"]",""));
            } else if (h.contains("set $")) {
                if (!h.contains("+") || !h.contains("-")) {
                    String key = h.replace("set $", "")
                            .split(" ", 2)[0];
                    String[] s2_array = h.replace("set $", "")
                            .replace(key, "")
                            .split("\\D+");
                    Integer numbers = Integer.parseInt(String.join("", s2_array));
                    variablesAndTheirValues.put(key, numbers);
                } else {
                    result = h.replace("set $", "")
                            .split(" ", 2)[0]
                            .replaceAll("[\s]", "");
                }
            }
        }
    }
}
