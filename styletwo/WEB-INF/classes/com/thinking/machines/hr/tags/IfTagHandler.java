package com.thinking.machines.hr.tags;
import javax.servlet.jsp.tagext.*;

public class IfTagHandler extends TagSupport
{
private boolean condition;

public void setCondition(boolean condition)
{
this.condition=condition;
}

public boolean getCondition()
{
return this.condition;
}

public IfTagHandler()
{
reset();
}

private void reset()
{
this.condition=false;
}

public int doStartTag()
{
if(condition==true) return EVAL_BODY_INCLUDE;
return SKIP_BODY;
}

public int doEndTag()
{
reset();
return super.EVAL_PAGE;
}
}