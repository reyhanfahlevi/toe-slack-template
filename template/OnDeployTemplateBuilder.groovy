package template

@groovy.transform.InheritConstructors
class OnDeployTemplateBuilder extends SlackBotNotifyTemplate {
    public ArrayList BuildStarted() {
         def blocks = [
            [
                "type": "section",
                "text": [
                    "type": "mrkdwn",
                    "text": "Building *_${this.repoName}_* started"
                ]
            ]
        ]

        return blocks
    }

    public ArrayList BuildFinished(LinkedHashMap param) {
         def blocks = [
            [
                "type": "section",
                "text": [
                    "type": "mrkdwn",
                    "text": "Building *_${this.repoName}_* finished"
                ]
            ]
        ]

        return blocks
    }

    public ArrayList DeploymentStarted() {
         def blocks = [
            [
                "type": "section",
                "text": [
                    "type": "mrkdwn",
                    "text": "Deployment *_${this.repoName}_* started"
                ]
            ]
        ]

        return blocks
    }

    public ArrayList DeploymentFinished(LinkedHashMap param) {
         def blocks = [
            [
                "type": "section",
                "text": [
                    "type": "mrkdwn",
                    "text": "Deployment *_${this.repoName}_* finished"
                ]
            ]
        ]

        return blocks
    }

}

