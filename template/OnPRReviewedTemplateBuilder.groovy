package template

@groovy.transform.InheritConstructors
class OnPRReviewedTemplateBuilder extends SlackBotNotifyTemplate {
    public ArrayList ApprovedBy(LinkedHashMap param) {
        def additionalField = ""
        if (param.withComment) {
            additionalField = "with additional comment"
        }
ß
        def blocks =
        [
            [
                "type": "section",
                "text": [
                    "type": "mrkdwn",
                    "text": "> PR *_<${param.prLink}|${param.prNumber}>_* is ${param.action} by ${param.gitUser} ${additionalField}"
                ]
            ]
        ]
        return blocks
    }

    public ArrayList PRClosedBy(LinkedHashMap param) {
        def blocks = [
            [
                "type": "section",
                "text": [
                    "type": "mrkdwn",
                    "text": "Branch *_${this.branch}_* closed by *_${param.gitUser}_*"
                ]
            ]
        ]

        return blocks
    }
}