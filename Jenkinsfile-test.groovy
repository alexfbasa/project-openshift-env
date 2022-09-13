@Library('pipeline-shared-library') _

node {
    properties([
            parameters([
                    choice(choices: ['bullseye', 'buster', 'stretch', 'jessie'], description: 'Select your distro version',
                            name: 'distro'),
            ])
    ])
    stage ('Print Input Params'){
        println "The distro selected was: ${distro}"
    }
}