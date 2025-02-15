<h1><b>🎮 Flappy Bird Java Game</b></h1>

<h3><b>📖 Overview</b></h3>
<p>This project is a Java implementation of the classic Flappy Bird game using Java Swing for the graphical user interface. It features customizable bird characters, different backgrounds, and an intuitive menu system. The game provides a fun and challenging experience while demonstrating object-oriented programming principles and GUI development in Java.</p>

<h3><b>✨ Features</b></h3>
<ul>
  <li>Classic Flappy Bird gameplay mechanics</li>
  <li>Multiple selectable bird characters and backgrounds</li>
  <li>Score tracking system</li>
  <li>User-friendly menu interface</li>
  <li>Smooth animation and physics</li>
</ul>

<h3><b>⚙️ Prerequisites</b></h3>
<ul>
  <li><b>Java Development Kit (JDK)</b>: Version 8 or higher</li>
  <li><b>Integrated Development Environment (IDE)</b>: Any Java IDE (e.g., Eclipse, IntelliJ IDEA, NetBeans)</li>
  <li><b>Required Libraries</b>: Java Swing (included in JDK)</li>
</ul>

<h3><b>🔧 Installation</b></h3>
<ol>
  <li>Clone this repository to your local machine:
    <pre><code>git clone https://github.com/MasterMar11/flappy_bird.git</code></pre>
  </li>
  <li>Navigate to the project directory:
    <pre><code>cd flappy_bird</code></pre>
  </li>
  <li>Compile the Java files:
    <pre><code>javac *.java</code></pre>
  </li>
  <li>Run the game:
    <pre><code>java Main</code></pre>
  </li>
</ol>

<h3><b>📁 Project Structure</b></h3>
<pre>
flappy-bird-java/
├── src/
│   ├── Main.java              # Game entry point
│   ├── GameMenu.java          # Menu system implementation
│   ├── GameBoard.java         # Main game logic and rendering
│   ├── Bird.java             # Bird entity implementation
│   ├── Pipe.java             # Pipe obstacle implementation
│   └── resources/            # Game resources
│       ├── flappybird.png     # Default bird sprite
│       ├── flappybird_blue.png
│       ├── flappybird_red.png
│       ├── flappybird_golden.png
│       ├── flappybirdbg.png   # Default background
│       ├── flappybirdbg_night.png
│       ├── flappybirdbg_desert.png
│       ├── flappybirdbg_snow.png
│       ├── toppipe.png
│       └── bottompipe.png
</pre>

<h3><b>💻 Usage</b></h3>
<p>After launching the game:</p>
<ol>
  <li>Select your preferred bird character and background from the main menu</li>
  <li>Press the Start Game button to begin</li>
  <li>Use the SPACE key to make the bird fly/jump</li>
  <li>Navigate through the pipes without hitting them</li>
  <li>Try to achieve the highest score possible</li>
  <li>After the game over, you need to restart the game if you want to change the bird or the gameboard. If you want to continue the game with the same settings, simply press Enter.</li>
</ol>

<h3><b>🎮 Game Controls</b></h3>
<ul>
  <li><b>SPACE</b>: Make the bird jump/fly</li>
  <li><b>Menu Navigation</b>: Mouse click for selections</li>
</ul>

<h3><b>🔍 Technical Details</b></h3>
<ul>
  <li>Written in Java using Swing for GUI</li>
  <li>Implements object-oriented design principles</li>
  <li>Uses double buffering for smooth graphics</li>
  <li>Timer-based game loop for consistent updates</li>
  <li>Collision detection system</li>
  <li>State management for game flow</li>
</ul>

<h3><b>🙌 Contributing</b></h3>
<p>Contributions are welcome! Here's how you can help:</p>
<ul>
  <li>Report bugs and issues</li>
  <li>Suggest new features</li>
  <li>Add new bird characters or backgrounds</li>
  <li>Improve game mechanics</li>
  <li>Optimize performance</li>
</ul>

<h3><b>📜 License</b></h3>
<p>This project is licensed under the MIT License. You are free to use, modify, and distribute this project, but please refer to the LICENSE file for full details and terms.</p>
