package de.metas.banking.payment.process;

import org.adempiere.model.InterfaceWrapperHelper;
import org.compiere.model.I_C_PaySelection;

import de.metas.banking.model.I_C_BankStatement;
import de.metas.banking.payment.IPaySelectionBL;
import de.metas.document.engine.IDocument;
import de.metas.document.engine.IDocumentBL;
import de.metas.process.IProcessPrecondition;
import de.metas.process.IProcessPreconditionsContext;
import de.metas.process.JavaProcess;
import de.metas.process.ProcessInfoParameter;
import de.metas.process.ProcessPreconditionsResolution;
import de.metas.util.Check;
import de.metas.util.Services;

public class C_BankStatementLine_CreateFrom_C_PaySelection extends JavaProcess implements IProcessPrecondition
{
	private final IPaySelectionBL paySelectionBL = Services.get(IPaySelectionBL.class);

	private final IDocumentBL docActionBL = Services.get(IDocumentBL.class);
	
	private int p_C_PaySelection_ID;

	@Override
	protected void prepare()
	{
		final ProcessInfoParameter[] para = getParametersAsArray();

		for (int i = 0; i < para.length; i++)
		{
			final String name = para[i].getParameterName();

			if (name.equals(I_C_PaySelection.COLUMNNAME_C_PaySelection_ID))
			{
				p_C_PaySelection_ID = para[i].getParameterAsInt();
			}
		}
	}

	@Override
	protected String doIt() throws Exception
	{
		Check.errorIf(getRecord_ID() <= 0, "Process {} needs to be run with a Record_ID", this);

		final I_C_PaySelection paySelection = InterfaceWrapperHelper.create(getCtx(), p_C_PaySelection_ID, I_C_PaySelection.class, getTrxName());
		final I_C_BankStatement bankStatement = InterfaceWrapperHelper.create(getCtx(), getRecord_ID(), I_C_BankStatement.class, getTrxName());

		paySelectionBL.createBankStatementLines(bankStatement, paySelection);

		return "@Success@";
	}

	/**
	 * @return <code>true</code> if the given gridTab belongs to a bank statement that is drafted or in progress
	 */
	@Override
	public ProcessPreconditionsResolution checkPreconditionsApplicable(final IProcessPreconditionsContext context)
	{
		if (I_C_BankStatement.Table_Name.equals(context.getTableName()))
		{
			final I_C_BankStatement bankStatement = context.getSelectedModel(I_C_BankStatement.class);
			return ProcessPreconditionsResolution.acceptIf(docActionBL.isDocumentStatusOneOf(bankStatement,
					IDocument.STATUS_Drafted, IDocument.STATUS_InProgress));
		}
		return ProcessPreconditionsResolution.reject();
	}
}
