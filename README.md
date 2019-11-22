# Template for ToE

## OnPush Template

OnPush template will create a `blocks` that needed by the jenkins slack plugins.

### How to Use

Instantiate the template builder:

```groovy

def t = new OnPushTemplateBuilder(token: '6a0f8a55-2728-4354-9bba-f8db81a058d2', channel:'toe-alert-space', branch: 'rey_setup_mailer', jenkinsLink:'http://tokopedia.com', sonarDashboard: 'http://tokopedia.com', githubLink: "https://github.com/tokopedia/static-code-auto-scanner")
```

Example Call:

```groovy

t.BeingScanned()

t.ScanFinished(coverage: "60%", vuln: 0, bug: 0, codesmells: 0, targetBranch: "master"))

t.PRClosed(prLink: "https://tokopedia.com",prNumber: 270)

```

Example sending to slack:

```groovy

// must set bot user to true
slackSend(botUser: true, channel: t.GetChannel(), blocks: t.BeingScanned(), tokenCredentialId: t.GetToken())

```
