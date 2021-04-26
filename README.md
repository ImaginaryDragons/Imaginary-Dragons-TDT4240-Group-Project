# ImaginaryDragonsGame
This game was made as a part of the course "TDT4240 - Softwar archtiecture" at the Norwegian University of Science and Technology. In this project, the main task is to make a functioning multiplayer game or fun app for Android or iPhone, based on your own game concept.


## About the game
This game is inspired by Playing With Fire - a bomberman style game multi-player game. The aim of the game is to plant bombs that explode in order to kill the enemy or enemies. The players, here represented as dragon characters, start off in each corner of the map, blocked from each other with different obstacles. In order to make your way to the enemy, the player has to destroy blocks by dropping fireballs. The fire will destroy the obstacles and eventually paths to the other players are made. The aim then is to tactically plant fires in order to blow up the other players without dying yourself. Power-ups are hidden under different block that will give the player special abilities when picked up. Examples of such abilities include speed upgrade and a wider range for your fire. Each player has three lives. A life is lost when the player is hit by fire. The goal of the game is to be last man standing. There is a 5-minute time limit and the winner of the game will get a score, which is the time spent on killing the enemy. The less time you use, the higher you will get on the high score list.

## Installation
### On Android device
1. Make sure your android device has an API level 16 or later.
2. Make sure that the browser you are downloading the APK-file from has enabled downloads from unkown sources (Settings → Security → Install from unkown sources → Enable your browser of choice). 
3. Go to this link: https://drive.google.com/file/d/1yjW4ivkj0mlNufQvlakWa50WaRqIJQID/view?usp=sharing 
4. Install the APK on your device.
5. If you get an error, try to open the link incognito. 
6. Open the installed app to play. 

### On computer
1. Clone the repo using:
 ```bash 
git clone <https://github.com/ImaginaryDragons/ImaginaryDragonsGame.git>
```
2. Open the project in Android Studio
3. Run the project with an Android emulator, an Android device connected to your computer, or in DesktopLauncher.

#### Running in DesktopLauncher
In order for the desktop application to run you might have to edit the configurations. This can be done by opening the project in Android Studio and selecting "Edit Configurations..." from the Run menu. Add a new Application runtime configuration. Within this configuration, set the working directory the assets folder, which can be found in the Android folder. Furthermore, the "use classpath of module" option should be set to desktop. The "Main class" option should be set to "DesktopLauncher".

From this point on you can run the application with the newly created run configuration by selecting it within Android studio and then clicking the "Run" button.


## How to play
In the Menu screen, you can choose between two buttons, "Play" and "High Scores". Pressing "Play" will send you to a screen where you can choose between different levels. Pressing one of these will start the game.  

### On Android Device
In both ends of the phone, there is a joystick and a button that says "bomb". The joysticks are used to steer the player, while the bomb button is used to release the fire bombs. The three hearts displays the number of lifes you have left. When a powerup appears, you will automatically get a boost in the given power when you move over the power up field.

### On computer/desktop
If you are running the game on desktop on your computer, you can use the keyboard. For player 1 you use the arrow-keys to move and place a bomb with the M-key. For player 2 you use the WASD-keys to move and place a bomb with the Q-key.

![](https://media.giphy.com/media/wxObcOKXjevYNYCUCf/giphy.gif)



