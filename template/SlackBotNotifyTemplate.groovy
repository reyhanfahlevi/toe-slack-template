package template

class SlackBotNotifyTemplate {
    def token
    def channel
    def branch
    def sonarDashboard 
    def jenkinsLink
    def githubLink
    def repoName

    SlackBotNotifyTemplate(LinkedHashMap map) {
        this.token = map.token
        this.channel = map.channel
        this.branch = map.branch
        this.sonarDashboard = map.sonarDashboard
        this.jenkinsLink = map.jenkinsLink
        this.githubLink = map.githubLink
        this.repoName = map.repoName
    }

    public String GetPRLink(targetBranch) {
        return "${this.githubLink}/compare/${targetBranch}...${this.branch}?expand=1"
    }

    public String GetBranch() {
        return this.branch
    }

    public String GetChannel() {
        return this.channel
    }

    public String GetToken() {
        return this.token
    }

    public String GetRepoName() {
        return this.repoName
    }
}