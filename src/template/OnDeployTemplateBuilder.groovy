package template

@groovy.transform.InheritConstructors
class OnDeployTemplateBuilder extends SlackBotNotifyTemplate {
    public LinkedHashMap BuildStarted() {
         def blocks = [
            [
                "type": "section",
                "text": [
                    "type": "mrkdwn",
                    "text": "> Building *_${this.GetRepoName()}_* started"
                ]
            ]
        ]

        return this.BuildSlackParam(blocks: blocks)
    }

    public LinkedHashMap BuildFinished(LinkedHashMap param) {
         def blocks = [
            [
                "type": "section",
                "text": [
                    "type": "mrkdwn",
                    "text": "> Building *_${this.GetRepoName()}_* finished"
                ]
            ]
        ]

        return this.BuildSlackParam(blocks: blocks)
    }

    public LinkedHashMap DeploymentStarted() {
         def blocks = [
            [
                "type": "section",
                "text": [
                    "type": "mrkdwn",
                    "text": "> Deployment *_${this.GetRepoName()}_* started"
                ]
            ]
        ]

        return this.BuildSlackParam(blocks: blocks)
    }

    public LinkedHashMap DeploymentFinished(LinkedHashMap param) {
         def blocks = [
            [
                "type": "section",
                "text": [
                    "type": "mrkdwn",
                    "text": "> Deployment *_${this.GetRepoName()}_* finished"
                ]
            ]
        ]

        return this.BuildSlackParam(blocks: blocks)
    }

}

