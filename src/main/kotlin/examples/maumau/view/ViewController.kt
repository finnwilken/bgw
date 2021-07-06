package examples.maumau.view

import examples.maumau.controller.LogicController
import examples.maumau.model.CardSuit
import examples.maumau.model.MauMauCard
import tools.aqua.bgw.core.BoardGameApplication
import tools.aqua.bgw.elements.gameelements.CardView
import tools.aqua.bgw.event.DragEvent
import tools.aqua.bgw.util.BidirectionalMap
import kotlin.system.exitProcess

class ViewController : BoardGameApplication("MauMau") {
	
	val gameScene: GameScene = GameScene()
	val mauMauMenuScene: MauMauMenuScene = MauMauMenuScene()
	
	val refreshViewController: RefreshViewController = RefreshViewController(this)
	val logicController: LogicController = LogicController(refreshViewController)
	
	val cardMap: BidirectionalMap<MauMauCard, CardView> = BidirectionalMap()
	
	init {
		registerGameEvents()
		registerMenuEvents()
		
		showGameScene(gameScene)
		showMenuScene(mauMauMenuScene)
		show()
	}
	
	private fun registerGameEvents() {
		gameScene.hintButton.onMouseClicked = { logicController.showHint() }
		
		gameScene.gameStackView.dropAcceptor = this::tryElementDropped
		gameScene.gameStackView.onDragElementDropped = this::elementDropped
		
		gameScene.drawStackView.onMouseClicked = {
			if (!logicController.game.drawStack.isEmpty())
				logicController.drawCard()
		}
		
		gameScene.buttonDiamonds.onMousePressed = { logicController.selectSuit(CardSuit.DIAMONDS) }
		gameScene.buttonHearts.onMousePressed = { logicController.selectSuit(CardSuit.HEARTS) }
        gameScene.buttonSpades.onMousePressed = { logicController.selectSuit(CardSuit.SPADES) }
        gameScene.buttonClubs.onMousePressed = { logicController.selectSuit(CardSuit.CLUBS) }
    }
	
	private fun tryElementDropped(event: DragEvent): Boolean {
		println("Element Dropped! ${event.draggedElement.posX}|${event.draggedElement.posY}")
		if (event.draggedElement !is CardView)
			return false
		
		return logicController.checkRules(cardMap.backward(event.draggedElement))
	}
	
	private fun elementDropped(event: DragEvent) {
		logicController.playCard(cardMap.backward(event.draggedElement as CardView), false)
		
		println("${event.draggedElement.posX}|${event.draggedElement.posY}")
	}
	
	var i = 0
	private fun registerMenuEvents() {
		gameScene.mainMenuButton.onMouseClicked = {
			showMenuScene(mauMauMenuScene)
		}
		
		mauMauMenuScene.continueGameButton.onMouseClicked = {
			hideMenuScene()
		}
        
        mauMauMenuScene.newGameButton.onMouseClicked = {
            logicController.newGame()
            hideMenuScene()
        }
        
        mauMauMenuScene.exitButton.onMouseClicked = {
            exitProcess(0)
        }
    }
}
