# ContariaCalc
Calculator for Pre 1.9 Minecraft Java Speedrunning
by KingContaria


How to use the Calculator:


After throwing an eye, point your crosshair at the eye of ender, then fill your x and z coordinate and the horizontal angle you are looking at into the first Textfield. Leave spaces between the values.

Now turn 90°, run for a bit and then repeat this process for a second eyethrow and fill in the values into the second Textfield.

I would advise travelling at least 50 blocks between eyethrows, 100 to be sure or when you are outside of the stronghold ring.

Now click the 'Find' Button and the calculator will output the coordinates of the stronghold. Depending on the distance between eyethrow, the distance of the stronghold and your accuracy when taking the angle those coordinates might not be exact.


Buttons:


... - This will hide most of the Calculator / show the part again when its hidden.

Settings - This will open up a window with settings.

Clear - This will clear all TextFields and remove stronghold coordinates and other values.


Settings:


ClipboardReader - If this is enabled, the program will check for copied texts in the x z a format and automatically paste them into the Textfields.

Check every __ ms - Sets the time in what intervalls the program checks for a new clipboard value, write the number of ms into the Textfield and then press ✓.

Show Distance to SH - If this is enabled, additionally to the coordinates of the stronghold the program will also give you its distance.

Distance from - This determines the point from where distance to the stronghold is calculated, either the x and z coordinate from your first, your second or both your eyethrows.

Show Nether Coords - This will create an additional field below the stronghold coordinates that tells you the according nether coordinates of your stronghold.

Nether Coords Decimals - This determines how many decimals of the nether coordinates will be shown.

Show Chunk Coords - This will create an additional field below the stronghold coordinates that tells you the chunk coordinates of the stronghold.

Always On Top - If this is enabled, the window will always stay on top, even when other windows are selected (for example Minecraft).

Translucent - If this is enabled, the window will get translucent.

Autoclear - If this is enabled, after you press 'Find' a timer will start after which the Calculator will automatically get cleared. The timer will start over if you press 'Find' and get cancelled if you press 'Clear'.

Autoclear after __ min - Sets the duration for the timer, write the number of minutes into the Textfield and then press ✓.

Hide when cleared - If this is enabled, the Hide Function will automatically be activated when the Calculator gets cleared.

Text Font - Enter the Name of the Text Font you want your text to be hear and then press ✓.

Resize - Use this to resize your calculator if it is too small/big. The 'Reset' button will set it back to its original size.

Color - Use this to change the color of your GUI.


Other Features:


Adding to your first throw - Instead of fully typing out the second throw coordinates and angle, you can also put a '+' in front of your number, that way it will add this number to the according variable from your first eyethrow. Example...

...

First Input: 100 200 49.5

Second Input: +50 180 +-2.3

means

Second Input: 150 180 47.2


Overwriting Eyethrows with ClipbaordReader - 3rd Clipboard throw overwrites first one, 4th overwrites second, etc...

