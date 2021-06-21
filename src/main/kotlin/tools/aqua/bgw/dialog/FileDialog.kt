package tools.aqua.bgw.dialog

import java.io.File

/**
 * A FileDialog such as a file chooser or save dialog, depending on FileDialogMode.
 *
 * @param mode The dialog's mode
 * @param title The dialog's title text
 * @param initialFileName The initial file name in the file name text box
 * @param initialDirectory The initial directory where to open the file chooser
 * @param extensionFilters Extensions filters for this file chooser
 *
 * @see tools.aqua.bgw.dialog.FileDialog.FileDialogMode
 * @see tools.aqua.bgw.dialog.ExtensionFilter
 */
data class FileDialog(
	val mode: FileDialogMode,
	val title: String = "",
	val initialFileName: String = "",
	val initialDirectory: File? = null,
	val extensionFilters: List<ExtensionFilter> = listOf()
) {
	/**
	 * Enum for possible FileDialog modes.
	 */
	enum class FileDialogMode {
		/**
		 * Mode to open one file.
		 */
		OPEN_FILE,
		
		/**
		 * Mode to open multiple files.
		 */
		OPEN_MULTIPLE_FILES,
		
		/**
		 * Mode to save a file.
		 */
		SAVE_FILE,
		
		/**
		 * Mode so select a directory.
		 */
		CHOOSE_DIRECTORY
	}
}