package template

@groovy.transform.InheritConstructors
class OnPRMergedTemplateBuilder extends SlackBotNotifyTemplate {
    public LinkedHashMap MergedBy(LinkedHashMap param) {
        def blocks = [
            [
                "type": "section",
                "text": [
                    "type": "mrkdwn",
                    "text": "> Branch *_${this.GetBranch()}_* merged by *_${param.gitUser}_*"
                ]
            ]
        ]

        return this.BuildSlackParam(blocks: blocks)
    }
}









