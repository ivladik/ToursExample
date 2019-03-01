package github.com.ivladik.toursexample.utils.resources

import android.content.Context

/**
 * @author Vladislav Falzan.
 */
class ContextResourcesHandler private constructor(val context: Context) : ResourcesHandler {

    override fun getString(stringRes: Int, vararg args: Any): String = context.getString(stringRes, args)

    override fun getQuantityString(pluralsRes: Int, quantity: Int, vararg formatArgs: Any): String {
        return context.resources
            .getQuantityString(pluralsRes, quantity, *formatArgs)
    }

    companion object {

        fun newInstance(context: Context) = ContextResourcesHandler(context.applicationContext)
    }
}