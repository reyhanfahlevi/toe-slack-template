package template

@groovy.transform.InheritConstructors
class OnPRMergedTemplateBuilder extends SlackBotNotifyTemplate {
    public ArrayList MergedBy(LinkedHashMap param) {
        def blocks = [
            [
                "type": "section",
                "text": [
                    "type": "mrkdwn",
                    "text": "Branch *_${this.branch}_* merged by *_${param.gitUser}_*"
                ]
            ]
        ]

        return blocks
    }
}









