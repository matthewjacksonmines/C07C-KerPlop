Pieces & Requirements:

Frog - Frog moves only through interaction, thus, does not implement Moveable. Extends GamePiece. Returns ADVANCE interaction.
KnightPiece - GamePiece, Moveable. Returns HIT interaction. Implements a random move algorithm.
LaserPiece - GamePiece, not movable. Returns KILL interaction. Interacts at a distance.
Statue - GamePiece, returns GET_POINT interaction.
SuspiciousStatue - GamePiece, implements Moveable. Returns KILL interaction. Implements a linear move algorithm.
Wall - GamePiece, does not implement Movable. Returns NONE interaction.
WaterBottle - Implements only Drawable, not movable or interactable through GamePiece.

Two levels setup in LevelSetup through setupLevel1 and setupLevel2 functions.