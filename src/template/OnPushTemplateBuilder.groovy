package template

@groovy.transform.InheritConstructors
class OnPushTemplateBuilder extends SlackBotNotifyTemplate {
    public LinkedHashMap BeingScanned() {
        def blocks = [
            [
                "type": "section",
                "text": [
                    "type": "mrkdwn",
                    "text": "> Branch *_${this.GetBranch()}_* is being scanned"
                ]
            ]
        ]
        return this.BuildSlackParam(blocks: blocks)
    }

    public LinkedHashMap ScanFinished(LinkedHashMap param) {
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
                    "text": "> Branch *_${this.GetBranch()}_* already scanned :tada:"
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
                        "url":"${this.GetSonarDashboard()}"
                    ]
                ]
            ]
        ]
        return this.BuildSlackParam(blocks: blocks)
    }

    public LinkedHashMap PRClosed(LinkedHashMap param) {
        def prNum = param.prNum
        def prLink = param.prLink

        def blocks = 
        [
            [
                "type": "section",
                "text": [
                    "type": "mrkdwn",
                    "text": "> PR <${prLink}|#${prNum}> is closed"
                ]
            ]
        ]

        return this.BuildSlackParam(blocks: blocks)
    }
} 
