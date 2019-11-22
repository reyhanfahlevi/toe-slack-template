class SlackBotNotifyTemplate {
    def token
    def channel
    def branch
    def sonarDashboard 
    def jenkinsLink
    def githubLink

    SlackBotNotifyTemplate(LinkedHashMap map) {
        this.token = map.token
        this.channel = map.channel
        this.branch = map.branch
        this.sonarDashboard = map.sonarDashboard
        this.jenkinsLink = map.jenkinsLink
        this.githubLink = map.githubLink
    }

    public String GetPRLink(targetBranch) {
        return "${this.githubLink}/compare/${targetBranch}...${this.branch}?expand=1"
    }

    public String GetChannel() {
        return this.channel
    }

    public String GetToken() {
        return this.token
    }
}


@groovy.transform.InheritConstructors
class OnPushTemplateBuilder extends SlackBotNotifyTemplate {
    public ArrayList BeingScanned() {
        def blocks = [
            [
                "type": "section",
                "text": [
                    "type": "mrkdwn",
                    "text": "> Branch *_${this.branch}_* is being scanned"
                ]
            ]
        ]
        return blocks
    }

    public ArrayList ScanFinished(LinkedHashMap param) {
        def coverage = param.coverage
        def bug = param.bug
        def codesmells = param.codesmells
        def vuln = param.vuln
        def createPRLink = this.GetPRLink(param.targetBranch)

        def blocks = 
        [
            [
                "type": "section",
                "text": [
                    "type": "mrkdwn",
                    "text": "> Branch *_${this.branch}_* already scanned :tada:"
                ],
                "accessory": [
                    "type": "button",
                    "text": [
                        "type": "plain_text",
                        "emoji": true,
                        "text": "Create PR"
                    ],
                    "url":"${createPRLink}"
                ]
            ],
            [
                "type": "section",
                "text": [
                    "type": "mrkdwn",
                    "text": "*We've got a report for you:*"
                ],
                "fields": [
                    [
                        "type": "mrkdwn",
                        "text": "*Coverage:*\n$coverage"
                    ],
                    [
                        "type": "mrkdwn",
                        "text": "*Bug:*\n$bug"
                    ],
                    [
                        "type": "mrkdwn",
                        "text": "*Code Smells:*\n$codesmells"
                    ],
                    [
                        "type": "mrkdwn",
                        "text": "*Vulnerability:*\n$vuln"
                    ]
                ]
            ],
            [
                "type": "actions",
                "elements": [
                    [
                        "type": "button",
                        "text": [
                            "type": "plain_text",
                            "emoji": true,
                            "text": "Sonar Dashboard"
                        ],
                        "url":"${this.sonarDashboard}"
                    ]
                ]
            ]
        ]
        return blocks
    }

    public ArrayList PRClosed(LinkedHashMap param) {
        def prNumber = param.prNumber
        def prLink = param.prLink

        def blocks = 
        [
            [
                "type": "section",
                "text": [
                    "type": "mrkdwn",
                    "text": "> PR <${prLink}|#${prNumber}> is closed"
                ]
            ]
        ]

        return blocks
    }
} 

@groovy.transform.InheritConstructors
class OnPROpenTemplateBuilder extends SlackBotNotifyTemplate {
    
}

@groovy.transform.InheritConstructors
class OnPRReviewedTemplateBuilder extends SlackBotNotifyTemplate {
    
}

@groovy.transform.InheritConstructors
class OnPRMergedTemplateBuilder extends SlackBotNotifyTemplate {
    
}

@groovy.transform.InheritConstructors
class OnDeployTemplateBuilder extends SlackBotNotifyTemplate {
    
}











