package training.journal.activities

import training.journal.R

abstract class BaseNoAppbarActivity : BaseActivity() {

    override fun isToolbarEnabled(): Boolean = false

    override fun getActivityLayoutId(): Int = R.layout.activity_no_appbar
}