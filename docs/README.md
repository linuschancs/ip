# BetaGo User Guide
BetaGo is a personal assistant Chatbot that can help you keep track of
your various tasks! 


## Quickstart
1. Ensure that you have **Java 11** installed on your computer.
2. Download the latest `betago.jar` file from [here](https://github.com/linuschancs/ip/releases/download/A-Release/betago.jar).
3. Copy the file to the folder you want to use as your home folder.
4. Double-click the file to start using BetaGo!
5. Refer to the [Command Summary](#command-summary) table for a quick guide on what commands you may give to BetaGo.


## Features 

### Types of Tasks

BetaGo can keep track of three different types of tasks:
- **_Todo_** : A general task represented with a description
- **_Deadline_** : A deadline task represented with a description and date that it should be completed by
- **_Event_** : An event task represented with a description, date and time that the event is happening at

### Task List Management

Betago allows you to easily:
- Add and delete tasks into a task list
- Keep track of which tasks are completed by marking the tasks
- Search for specific tasks in the list using keywords
- Load and Save tasks from a `.txt` file


## Usage
Notes about the command format:
- Words in brackets `()` refer to fields that are **compulsory** and require the respective input from the user
- Fields that require a date input should be in one of the following formats:
  - `yyyy-MM-dd`
  - `dd-MMM-yyyy`
  - `dd/MM/yyyy`
- Fields that require a time input should be in the 2400 time format eg. `1800` or `0230`
- Index fields refer to the specific index of the task in the current list

### `load` - Load a data file

Loads a pre-existing data file containing previously saved tasks from BetaGo.

Format:

`load (filename)`

Example:

```
load newdata.txt
```
### `todo` - Add a todo task

Adds a todo task into the task list.

Format: 

`todo (description)`

Example:

```
todo return a book
```

### `deadline` - Add a deadline task

Adds a deadline task into the task list.

Format:

`deadline (description) /by (date)`

Example:

```
deadline return a book /by 2023-10-25
```

### `event` - Adds an event task

Adds an event task into the task list.

Format:

`event (description) /at (date) (time)`

Example:

```
event library fair /at 2023-10-25 1700
```

### `list` - View all tasks

Lists all the tasks in the list.

Format:

`list`

### `delete` - Delete task

Deletes the specific task from the list.

Format:

`delete (index)`

Example:

```
delete 1
```
### `mark` - Mark task as completed

Marks a task from the list as completed

Format:

`mark (index)`

Example:

```
mark 2
```

### `unmark` - Unmark a completed task

Unmarks a completed task from the list.

Format:

`unmark (index)`

Example:

```
unmark 2
```
### `find` - Find tasks

Find tasks that have the corresponding keyword in their description.

Format:

`find (keyword)`

Example:

```
find book
```
### `bye` - Exit program

Exits the program.

Format:

`bye`

### Save data

Data is automatically saved into the `betago.txt` or the loaded file after every change in data of the list.

---

## Command Summary

| Command  | Format                                  | Example                             |
|----------|-----------------------------------------|-------------------------------------|
| load     | `load (filename)`                       | load newdata.txt                    |
| todo     | `todo (description)`                    | todo return book                    |
| deadline | `deadline (description) /by (date)`     | deadline return book /by 2023-08-09 |
| event    | `event (description) /at (date) (time)` | event book fair /at 2023-08-09 1700 |
| list     | `list`                                  | list                                |
| delete   | `delete (index)`                        | delete 1                            |
| mark     | `mark (index)`                          | mark 2                              |
| unmark   | `unmark (index)`                        | unmark 2                            |
| find     | `find (keyword)`                        | find book                           |
| bye      | `bye`                                   | bye                                 |
