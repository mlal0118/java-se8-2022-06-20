package task;

import java.util.regex.Pattern;

public class RegexpDemo {
    public static void main(String[] args) {
        var pattern = Pattern.compile("href=\"([^\"]*)\"");
        var matcher = pattern.matcher("<a href=\"https://dex.hu/x.php?id=inxcl&amp;url=https%3A%2F%2Findex.hu%2Fkulfold%2F2022%2F06%2F20%2Fvilag-legnagyobb-edesvizi-hala-mekong-folyo%2F\">");
        if (matcher.find()) {
            System.out.println(matcher.group(1));
        }

        matcher.results().map(r -> r.group(1)).forEach(System.out::println);
    }

}
