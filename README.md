# Android Project 5 - *Name of App Here*

Submitted by: **Neranti Gary**

**GetFit** is a health metrics app that allows users to track workout routines.

Time spent: **9** hours spent in total

## Required Features

The following **required** functionality is completed:

- [X] **At least one health metric is tracked (based on user input)**
  - Chosen metric(s): `Exercise Sessions`
- [X] **There is a "create entry" UI that prompts users to make their daily entry**
- [X] **New entries are saved in a database and then updated in the RecyclerView**
- [X] **On application restart, previously entered entries are preserved (i.e., are *persistent*)**
 
The following **optional** features are implemented:

- [ ] **Create a UI for tracking averages and trends in metrics**
- [ ] **Improve and customize the user interface through styling and coloring**
- [ ] **Implement orientation responsivity**
- [ ] **Add a daily photo feature**

The following **additional** features are implemented:

- [X] List anything else that you can get done to improve the app functionality!
- You are allowed to edit the exercise sessions as well.

## Video Walkthrough

Here's a walkthrough of implemented user stories:

![Video Walkthrough](project5_walkthrough.gif)

<!-- Replace this with whatever GIF tool you used! -->
GIF created with ...  QuickMovie + Imgur

## Notes

One major challenge was ensuring that exercise data, like names, sets, and reps, was correctly preserved as the user typed. Initially, new exercise rows stored only default empty values internally, so nothing saved to the database.

Setting up Room with two entities (WorkoutEntity and ExerciseEntity) exposed several dependency and annotation issues. Early on, the AppDatabase class only referenced the workouts table, causing Room to complain that the exercises table did not exist. Fixing this required adding ExerciseEntity to the entities array and updating the database version.

## License - NONE

    Copyright [yyyy] [name of copyright owner]

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.