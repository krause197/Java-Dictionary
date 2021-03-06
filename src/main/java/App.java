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
      model.put("phrases", Phrase.all());
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/phrases/new", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/phrase-form.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/phrases/new", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      String phrase = request.queryParams("phrase");
      Phrase newPhrase = new Phrase(phrase);
      response.redirect("/");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());


    get("/phrases/:id", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      Phrase phrase = Phrase.find(Integer.parseInt(request.params(":id")));
      model.put("phrase", phrase);
      model.put("template", "templates/phrases.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/phrases/:id/definitions/new", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      Phrase phrase = Phrase.find(Integer.parseInt(request.params(":id")));
      model.put("phrase", phrase);
      model.put("template", "templates/definition-form.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/phrases/:id/definitions/new", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      Definition definition = new Definition (request.queryParams("definition"));
      int phraseId = Integer.parseInt(request.params(":id"));
      Phrase phrase = Phrase.find(phraseId);
      phrase.addDefinition(definition);
      response.redirect("/phrases/" + phraseId);
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

  }
}
