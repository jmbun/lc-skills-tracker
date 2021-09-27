package org.launchcode.skillstracker.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SkillsController {
    @GetMapping
    @ResponseBody
    public String home() {
        String html =
        "<html>" +
            "<h1>Skills Tracker</h1>" +
            "<h2>We have a few skills we would like to learn. Here is a list!</h2>" +
            "<ol>" +
                "<li>C#</li>" +
                "<li>Java</li>" +
                "<li>Lua</li>" +
            "</ol>" +
        "</html>";
        return html;
    }

    @GetMapping("form")
    @ResponseBody
    public String helloForm() {
        String html =
        "<html>" +
            "<body>" +
                "<form method = 'post'>" +
                    "<label for='fname'>Name:</label><br>" +
                    "<input type='text' id='name' name='name'><br>" +
                    "<label for='lang1'>My favorite language:</label><br>" +
                    selectElement("lang1") + "<br>" +
                    "<label for='fname'>My second favorite language:</label><br>" +
                    selectElement("lang2") + "<br>" +
                    "<label for='fname'>My third favorite language:</label><br>" +
                    selectElement("lang3") + "<br>" +
                    "<input type = 'submit' value = 'Submit!'/>" +
                "</form>" +
            "</body>" +
        "</html>"
        ;
        return html;
    }

    @PostMapping("form")
    @ResponseBody
    public String helloForm2(@RequestParam String name, @RequestParam String lang1, @RequestParam String lang2, @RequestParam String lang3) {
        return String.format(
        "<html>" +
            "<h1>%s</h1>" +
            "<ol>" +
            "<li>%s</li>" +
            "<li>%s</li>" +
            "<li>%s</li>" +
            "</ol>" +
        "</html>",
        name, lang1, lang2, lang3
        );
    }

    private String selectElement(String id) {
        return String.format(
                "<select name='%s' id='%s'>" +
                        "<option value='C#'>C#</option>" +
                        "<option value='Java'>Java</option>" +
                        "<option value='Lua'>Lua</option>" +
                        "</select>",
                id, id
        );
    }
}
