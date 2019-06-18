


const Octokit = require('@octokit/rest')
const octokit = new Octokit({
    auth: {
        username: 'dv66',
        password: '.Heydipto9396',
        async on2fa () {
            // example: ask the user
            return prompt('Two-factor authentication Code:')
        }
    }
})

async function getRepos(){
    let val = await octokit.repos.list()
    console.log(val)
}

getRepos();
