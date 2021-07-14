@file:Suppress("unused", "MemberVisibilityCanBePrivate")

package tools.aqua.bgw.event

import tools.aqua.bgw.elements.ElementView

/**
 * Event that gets raised for drop gestures.
 * Receiver is the dragged element.
 *
 * @param draggedElement currently dragged [ElementView].
 * @param dragTargets list of all [ElementView]s that accepted the drag gesture in case of a dragGestureEnded [Event].
 * Contains all accepting [ElementView]s in the order they accepted.
 *
 * @see DragEvent
 */
class DropEvent(val draggedElement: ElementView, val dragTargets: List<ElementView> = listOf()) : Event()