package de.metas.handlingunits.model;

/*
 * #%L
 * de.metas.handlingunits.base
 * %%
 * Copyright (C) 2015 metas GmbH
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 2 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/gpl-2.0.html>.
 * #L%
 */


import java.math.BigDecimal;

public interface I_M_ReceiptSchedule extends de.metas.tourplanning.model.I_M_ReceiptSchedule
{
	// @formatter:off
	public static final String COLUMNNAME_M_HU_PI_Item_Product_ID = "M_HU_PI_Item_Product_ID";
	public void setM_HU_PI_Item_Product_ID(int M_HU_PI_Item_Product_ID);
	public void setM_HU_PI_Item_Product(I_M_HU_PI_Item_Product M_HU_PI_Item_Product);
	public int getM_HU_PI_Item_Product_ID();
	public I_M_HU_PI_Item_Product getM_HU_PI_Item_Product();
	// @formatter:on

	// @formatter:off
	public static final String COLUMNNAME_PackDescription = "PackDescritpion";
	public void setPackDescription(String PackDescription);
	public String getPackDescription();
	// @formatter:on

	// @formatter:off
	public static final String COLUMNNAME_QtyItemCapacity = "QtyItemCapacity";
	public void setQtyItemCapacity(BigDecimal QtyItemCapacity);
	public BigDecimal getQtyItemCapacity();
	// @formatter:on

	// @formatter:off
	public static final String COLUMNNAME_QtyMovedTU = "QtyMovedTU";
	public BigDecimal getQtyMovedTU();
	// public void setQtyMovedTU(BigDecimal QtyMovedTU); // virtual column
	// @formatter:on

	// @formatter:off
	// begin task 06570
	@Override
	public boolean isPackagingMaterial();
	// @formatter:on

	// @formatter:off
	public static final String COLUMNNAME_M_HU_LUTU_Configuration_ID = "M_HU_LUTU_Configuration_ID";
	//public void setM_HU_LUTU_Configuration_ID(int M_HU_LUTU_Configuration_ID);
	public void setM_HU_LUTU_Configuration(I_M_HU_LUTU_Configuration M_HU_LUTU_Configuration);
	//public int getM_HU_LUTU_Configuration_ID();
	public I_M_HU_LUTU_Configuration getM_HU_LUTU_Configuration();
	// @formatter:on
}
