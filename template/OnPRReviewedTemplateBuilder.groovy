package template

@groovy.transform.InheritConstructors
public class OnPRReviewedTemplateBuilder extends SlackBotNotifyTemplate {
    public ArrayList ApprovedBy(LinkedHashMap param) {
        def additionalField = ""
        if (param.withComment) {
            additionalField = "with additional comment"
        }

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

    }
}