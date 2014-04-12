package org.hidetake.gradle.ssh.registry

import org.hidetake.gradle.ssh.api.operation.Operations
import org.hidetake.gradle.ssh.api.operation.SftpHandler
import org.hidetake.gradle.ssh.api.session.SessionHandler
import org.hidetake.gradle.ssh.api.session.Sessions
import org.hidetake.gradle.ssh.api.ssh.ConnectionManager
import org.hidetake.gradle.ssh.internal.operation.DefaultOperationsFactory
import org.hidetake.gradle.ssh.internal.operation.DefaultSftpHandler
import org.hidetake.gradle.ssh.internal.session.DefaultSessionHandler
import org.hidetake.gradle.ssh.internal.session.DefaultSessions
import org.hidetake.gradle.ssh.internal.ssh.DefaultConnectionManager

/**
 * A component registry.
 *
 * @author hidetake.org
 */
@Singleton
class Registry {
    @SuppressWarnings("GroovyUnusedDeclaration")
    @Delegate
    private final RegistrySupport registrySupport = new RegistrySupport()

    private Registry() {
        factory(Sessions.Factory) >> DefaultSessions
        factory(SessionHandler.Factory) >> DefaultSessionHandler
        factory(ConnectionManager.Factory) >> DefaultConnectionManager

        factory(SftpHandler.Factory) >> DefaultSftpHandler

        singleton(Operations.Factory) >> DefaultOperationsFactory.instance
    }
}
