import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/phrases/new", (request, response) -> {
      Map<String, Object> model = newHashMap<String, Object>();
      model.put("template", "templates/Phrase-form.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/phrases", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("Phrases", Phrase.all());
      model.put("template", "templates/Phrases.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/phrases", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      String stringUserPhrase = request.queryParams("userWord");
      Phrase userWord = new Phrase(stringUserPhrase);
      model.put("template", "templates/word-success.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/phrases/:id", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      Phrase userPhrase = Phrase.find(Integer.parseInt(request.params(":id")));
      model.put("Phrase", userPhrase);
      model.put("template", "templates/phrase.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/phrases/:id/definitions/new", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      Phrase userPhrase = Phrase.find(Integer.parseInt(request.params(":id")));
      model.put("phrase", userPhrase);
      model.put("template", "template/definition-form.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/definitions", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      Phrase phrase = Phrase.find(Integer.parseInt(request.queryParams("phraseId")));
      String stringUserDefinition = request.queryParams("userDefinition");
      Definition userDefinition = new Definition(stringUserDefinition);
      phrase.addDefinition(userDefinition);
      model.put("template", "templates/definitionCreated.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/definitions", (request, response) -> {
      Map<String,Object> model = new HashMap<String, Object>();
      model.put("definitions", Definition.all());
      model.put("template", "templates/definitions.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

  }
}
