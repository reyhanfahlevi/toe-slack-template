import template.*

class Main {                                    
    static void main(String... args) {   
        def t = new template.OnDeployTemplateBuilder(token: "token", repoName: "affiliate")       
        println(t.BuildStarted())                 
    }
}