package template

@groovy.transform.InheritConstructors
class OnPROpenTemplateBuilder extends SlackBotNotifyTemplate {
    public LinkedHashMap PreCheckPR(LinkedHashMap param) {
        def blocks =
        [
            [
                "type": "section",
                "text": [
                    "type": "mrkdwn",
                    "text": "> We are doing pre-check on *_<${param.prLink}|${param.prNum}>_*."
                ]
            ]
        ]

        return this.BuildSlackParam(blocks: blocks)
    }

    public LinkedHashMap PRCheckPass() {
        def blocks =
        [
            [
                "type": "section",
                "text": [
                    "type": "mrkdwn",
                    "text": "> PR *_<${param.prLink}|${param.prNum}>_* already checked and *passed*."
                ]
            ]
        ]

        return this.BuildSlackParam(blocks: blocks)
    }

    public LinkedHashMap PRCheckFailed(LinkedHashMap param) {
       def blocks =
        [
            [
                "type": "section",
                "text": [
                    "type": "mrkdwn",
                    "text": "> PR *_<${param.prLink}|${param.prNum}>_* already checked and *not passed*. Please ask your team for a review."
                ]
            ]
        ]

        return this.BuildSlackParam(blocks: blocks)
    }
}