package de.metas.handlingunits.reservation;

import java.util.List;

import de.metas.handlingunits.HuId;
import de.metas.order.OrderLineId;
import de.metas.product.ProductId;
import de.metas.quantity.Quantity;
import lombok.Builder;
import lombok.NonNull;
import lombok.Singular;
import lombok.Value;

/*
 * #%L
 * de.metas.handlingunits.base
 * %%
 * Copyright (C) 2018 metas GmbH
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 2 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public
 * License along with this program. If not, see
 * <http://www.gnu.org/licenses/gpl-2.0.html>.
 * #L%
 */

@Value
public class ReserveHUsRequest
{
	/** always mandatory */
	Quantity qtyToReserve;

	/** always mandatory */
	OrderLineId salesOrderLineId;

	/** mandatory, if the given HUs contain different products. */
	ProductId productId;

	/**
	 * The HUs from which the respective {@link #qtyToReserve} shall be reserved. can be higher-level-HUs;
	 * The actual reservation is done on VHU level.
	 */
	List<HuId> huIds;

	@Builder
	private ReserveHUsRequest(
			@NonNull final Quantity qtyToReserve,
			@NonNull final OrderLineId salesOrderLineId,
			@NonNull final ProductId productId,
			@Singular final List<HuId> huIds)
	{
		this.qtyToReserve = qtyToReserve;
		this.salesOrderLineId = salesOrderLineId;
		this.productId = productId;
		this.huIds = huIds;
	}
}
