#!/bin/sh
# ====================================================================
# Copyright (c) 2006, 2017 THALES GLOBAL SERVICES.
# This program and the accompanying materials are made available under the
# terms of the Eclipse Public License 2.0 which is available at
# http://www.eclipse.org/legal/epl-2.0
#
# SPDX-License-Identifier: EPL-2.0
#
# Contributors:
#     Thales - initial API and implementation
# ====================================================================


# Get script parameter
# Verify parameter number => should be 2
if [ "$#" -lt 3 ]
then
>&2 echo "ERREUR ${scriptName} : This script should take 3 parameters to run it."
>&2 echo "Command : ${scriptName} productName componentName  buildType"
	exit 98
fi

# Extract parameters
export PRODUCT_NAME=$1
export COMPONENT_NAME=$2
export BUILD_TYPE=$3

# The type of build being published
if [ "$BUILD_TYPE" = "release" ]; then
	export BUILD_TYPE_PREFIX="R"
elif [ "$BUILD_TYPE" = "milestone" ]; then
	export BUILD_TYPE_PREFIX="M"
elif [ "$BUILD_TYPE" = "stable" ]; then
	export BUILD_TYPE_PREFIX="S"
fi

# The folder for this particular release updatesite
export TARGET_DIR_RELEASE="$TARGET_ROOT/$COMPONENT_NAME"
# The folder for this particular release product
export TARGET_DIR_RELEASE_PRODUCT="$TARGET_ROOT_PRODUCT"
