import template.OnPushTemplateBuilder

class Main {                                    
    static void main(String... args) {   
        def t = new OnPushTemplateBuilder(token: "token", repoName: "affiliate")       
        println(t.GetToken())                 
    }
}