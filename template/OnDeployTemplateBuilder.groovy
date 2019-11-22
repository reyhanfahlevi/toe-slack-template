package template

@groovy.transform.InheritConstructors
public class OnDeployTemplateBuilder extends SlackBotNotifyTemplate {
    public ArrayList BuildStarted() {
         def blocks = [
            [

            ]
        ]

        return blocks
    }

    public ArrayList BuildFinished(LinkedHashMap param) {
         def blocks = [
            [

            ]
        ]

        return blocks
    }

    public ArrayList DeploymentStarted() {
         def blocks = [
            [

            ]
        ]

        return blocks
    }

    public ArrayList DeploymentFinished(LinkedHashMap param) {
         def blocks = [
            [

            ]
        ]

        return blocks
    }

}

