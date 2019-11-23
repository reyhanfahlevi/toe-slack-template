package template

@groovy.transform.InheritConstructors
class OnPRReviewedTemplateBuilder extends SlackBotNotifyTemplate {
    public LinkedHashMap ApprovedBy(LinkedHashMap param) {
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
                    "text": "> PR *<${param.prLink}|#${param.prNum}>* is *_${param.reviewAction}_* by *_${param.gitUser}_* ${additionalField}"
                ]
            ]
        ]
        return this.BuildSlackParam(blocks: blocks)
    }

    public LinkedHashMap PRClosedBy(LinkedHashMap param) {
        def blocks = [
            [
                "type": "section",
                "text": [
                    "type": "mrkdwn",
                    "text": "> Branch *_${this.GetBranch()}_* closed by *_${param.gitUser}_*"
                ]
            ]
        ]

        return this.BuildSlackParam(blocks: blocks)
    }
}