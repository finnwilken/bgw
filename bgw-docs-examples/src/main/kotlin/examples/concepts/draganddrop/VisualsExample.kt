package examples.concepts.draganddrop

import tools.aqua.bgw.core.BoardGameApplication
import tools.aqua.bgw.core.BoardGameScene
import tools.aqua.bgw.elements.gameelements.TokenView
import tools.aqua.bgw.elements.uielements.Button
import tools.aqua.bgw.util.Font
import tools.aqua.bgw.visual.*
import java.awt.Color

fun main() {
	VisualsExample()
}

class VisualsExample : BoardGameApplication("Visuals example") {
	private val gameScene: BoardGameScene = BoardGameScene(background = ColorVisual.GRAY)
	
	private val token: TokenView = TokenView(posX = 860, posY = 400, height = 200, width = 200, visual = Visual.EMPTY)
	private val buttonColor: Button = Button(posX = 600, posY = 700, label = "ColorVisual").apply {
		visual = ColorVisual.LIGHT_GRAY
	}
	private val buttonImage: Button = Button(posX = 800, posY = 700, label = "ImageVisual").apply {
		visual = ColorVisual.LIGHT_GRAY
	}
	private val buttonText: Button = Button(posX = 1000, posY = 700, label = "TextVisual").apply {
		visual = ColorVisual.LIGHT_GRAY
	}
	private val buttonCompound: Button = Button(posX = 1200, posY = 700, label = "Compound").apply {
		visual = ColorVisual.LIGHT_GRAY
	}
	
	init {
		buttonColor.onMouseClicked = {
			token.visual = ColorVisual.GREEN
		}
		buttonImage.onMouseClicked = {
			token.visual = ImageVisual("Die.png")
		}
		buttonText.onMouseClicked = {
			token.visual = TextVisual(
				"Roll", Font(
					size = 20,
					color = Color.WHITE,
					fontWeight = Font.FontWeight.BOLD
				)
			)
		}
		buttonCompound.onMouseClicked = {
			token.visual = CompoundVisual(
				ImageVisual("Die.png"),
				
				ColorVisual.GREEN.apply { transparency = 0.4 },
				
				TextVisual(
					"Roll", Font(
						size = 40,
						color = Color.WHITE,
						fontWeight = Font.FontWeight.BOLD
					)
				)
			)
		}
		
		gameScene.addElements(token, buttonColor, buttonImage, buttonText, buttonCompound)
		showGameScene(gameScene)
		show()
	}
}