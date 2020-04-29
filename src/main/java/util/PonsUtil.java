package util;

import org.apache.http.client.fluent.Request;

public class PonsUtil {
    private String secret = "82955b813b1c11accb751b9cb7c2811d6522968c23055f674b9e61b1b179e64b";
    public String language;

    public PonsUtil(String language) {
        this.language = language;
    }

    public String getTranslation(String word) throws Exception{
        String result = Request.Get("https://api.pons.com/v1/dictionary?l=de" + getLanguage() + "&in=" + getLanguage() + "&q=" + word)
                    .addHeader("X-Secret", getSecret())
                    .connectTimeout(1000)
                    .socketTimeout(1000)
                    .execute().returnContent().asString();
            return result;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getSecret() {
        return secret;
    }
}
