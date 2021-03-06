/**
 * Copyright © 2016-2021 The Thingsboard Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.thingsboard.server.dao.firmware;

import com.google.common.util.concurrent.ListenableFuture;
import org.thingsboard.server.common.data.Firmware;
import org.thingsboard.server.common.data.FirmwareInfo;
import org.thingsboard.server.common.data.firmware.ChecksumAlgorithm;
import org.thingsboard.server.common.data.firmware.FirmwareType;
import org.thingsboard.server.common.data.id.DeviceProfileId;
import org.thingsboard.server.common.data.id.FirmwareId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.PageLink;

import java.nio.ByteBuffer;

public interface FirmwareService {

    FirmwareInfo saveFirmwareInfo(FirmwareInfo firmwareInfo);

    Firmware saveFirmware(Firmware firmware);

    String generateChecksum(ChecksumAlgorithm checksumAlgorithm, ByteBuffer data);

    Firmware findFirmwareById(TenantId tenantId, FirmwareId firmwareId);

    FirmwareInfo findFirmwareInfoById(TenantId tenantId, FirmwareId firmwareId);

    ListenableFuture<FirmwareInfo> findFirmwareInfoByIdAsync(TenantId tenantId, FirmwareId firmwareId);

    PageData<FirmwareInfo> findTenantFirmwaresByTenantId(TenantId tenantId, PageLink pageLink);

    PageData<FirmwareInfo> findTenantFirmwaresByTenantIdAndDeviceProfileIdAndTypeAndHasData(TenantId tenantId, DeviceProfileId deviceProfileId, FirmwareType firmwareType, boolean hasData, PageLink pageLink);

    void deleteFirmware(TenantId tenantId, FirmwareId firmwareId);

    void deleteFirmwaresByTenantId(TenantId tenantId);
}
