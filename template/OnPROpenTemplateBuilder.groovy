package template

@groovy.transform.InheritConstructors
public class OnPROpenTemplateBuilder extends SlackBotNotifyTemplate {
    public ArrayList PreCheckPR(LinkedHashMap param) {
        def blocks =
        [
            [
                "type": "section",
                "text": [
                    "type": "mrkdwn",
                    "text": "> We are doing pre-check on *_<${param.prLink}|${param.prNumber}>_*."
                ]
            ]
        ]

        return blocks
    }

    public ArrayList PRCheckPass() {
        def blocks =
        [
            [
                "type": "section",
                "text": [
                    "type": "mrkdwn",
                    "text": "> PR *_<${param.prLink}|${param.prNumber}>_* already checked and *passed*."
                ]
            ]
        ]

        return blocks
    }

    public ArrayList PRCheckFailed(LinkedHashMap param) {
       def blocks =
        [
            [
                "type": "section",
                "text": [
                    "type": "mrkdwn",
                    "text": "> PR *_<${param.prLink}|${param.prNumber}>_* already checked and *not passed*. Please ask your team for a review."
                ]
            ]
        ]

        return blocks
    }
}