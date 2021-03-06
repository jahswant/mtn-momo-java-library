package com.plydot.mtnmomoapi.products;

import com.plydot.mtnmomoapi.model.GetUserResponse;
import com.plydot.mtnmomoapi.model.TokenResponse;
import com.plydot.mtnmomoapi.model.collections.AccountBalance;
import com.plydot.mtnmomoapi.model.collections.Request2PayStatus;
import com.plydot.mtnmomoapi.utils.PayeIDType;

import java.io.NotActiveException;
import java.util.UUID;

public interface ICollections {
    /**
     * Create an api user
     * @return providerCallbackHost
     */
    String createUser();

    /**
     * Gets the current api user if created.
     * @return Target Env and Status
     */
    GetUserResponse getUser();

    /**
     * Make request to collect funds from a user account
     * @param amount e.g 1000
     * @param currency e.g EUR
     * @param account e.g 256787000000
     * @param message e.g Health Bill
     * @param payeIDType e.g PayeIDType.MSISDN
     * @param externalId any UUID or String
     * @return Transaction Status
     */

    Request2PayStatus makeCollectionRequest2Pay(String amount, String currency, String account, String message,
                                                PayeIDType payeIDType, UUID externalId, String Xreference) throws NotActiveException;

    Request2PayStatus makeCollectionRequest2Pay(String amount, String currency, String account, String message,
                                                PayeIDType payeIDType) throws NotActiveException;

    Request2PayStatus makeCollectionRequest2Pay(String amount, String currency, String account, String message,
                                                PayeIDType payeIDType, UUID externalId) throws NotActiveException;

    Request2PayStatus makeCollectionRequest2Pay(String amount, String currency, String account, String message,
                                                PayeIDType payeIDType, String XreferenceId) throws NotActiveException;

    /**
     * Checks for status of pay request
     * @param referenceId Can be obtained from the Request2PayStatus after making the request
     * @return Status
     */
    Request2PayStatus checkRequest2PayStatus(String referenceId) throws NotActiveException;

    /**
     * Get your collections account balance
     * @return Account balance with currency
     */
    AccountBalance getCollectionsBalance();

    TokenResponse getToken();
}
