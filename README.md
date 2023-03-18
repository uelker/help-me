# Help-Me

Help-Me is a simple Java console application that allows users to ask for help and receive an answer.
The purpose of this application is to provide users with quick and easy access to help and information on various topics.
Especially developers should have the possibility to ask questions and get an answer quickly via the terminal.
ChatGPT from OpenAI will be used to provide answers.


## Setup

1. Clone the repository: `git clone https://github.com/uelker/help-me.git`
2. Pass the API key from OpenAI in Main.java into the 'API_KEY' variable. The API key can be obtained from [OpenAI](https://openai.com/).
3. Start the Java Application
4. Put the Question in the Terminal

```console
Help me by: How can i list the running containers in docker?

You can list the running containers in Docker using the command: docker ps
```

## ToDo

Create a native image of the Application and put the path into the PATH variable. 
So the User can do this in the Terminal:

```console
help-me How can i list the running containers in docker?
```
